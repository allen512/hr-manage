package com.example.spring.util;

import com.example.spring.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;

//验证码过滤器,OncePerRequestFilter : 保证过滤器只被调用一次
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if ("/login".equals(request.getRequestURI())) {
            HttpSession session = request.getSession();
            String codeRequest = request.getParameter("verifyCode");
            Object codeSession = session.getAttribute("verCode");
            LocalDateTime localDateTime = (LocalDateTime) session.getAttribute("codeTime");

            if (codeSession == null || localDateTime == null) { //两分钟
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                RespBean error = RespBean.error("请刷新验证码");
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
                return;
            }

            long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


            if ((now - past) / 1000 / 60 > 2) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                RespBean error = RespBean.error("验证码已过期，请刷新验证码");
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
                return;
            }

            if (codeRequest == null || codeRequest.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                RespBean error = RespBean.error("验证码不能为空");
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
                return;
            }
            if (!codeRequest.equalsIgnoreCase(codeSession.toString())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                RespBean error = RespBean.error("验证码错误");
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
                return;
            }


            //验证成功，删除存储的验证码
            session.removeAttribute("verCode");
        }
        filterChain.doFilter(request, response);
    }
}
