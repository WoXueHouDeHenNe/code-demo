package com.example.demo.aop;

import com.example.demo.bean.User;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigInteger;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class ArgsAspect {

    @Pointcut("execution(* com.example.demo.controller.UserController.getUser(..))")
    public void argsPointCut() {}

    @Around("argsPointCut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("#ArgsAspect.before, 进入切面");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("#ArgsAspect.before, 切点中的第{}个参数{}", i, args[i]);
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            log.info("#ArgsAspect.before, 当前参数为, parameter: {}", parameter);
            Annotation annotation = parameter.getAnnotation(CookieValue.class);
            log.info("#ArgsAspect.before, 参数{}上的制定注解{}", parameter, annotation);

            if (Objects.nonNull(annotation)) {
                log.info("#ArgsAspect.before, 指定注解存在进行参数替换");
                args[i] = "参数修改";
            }
        }

        Object proceed = joinPoint.proceed(args);

        if (proceed instanceof User) {
            User user = (User) proceed;
            user.setUserName("修改后名称");
        }
        return proceed;
    }

    @Pointcut("execution(* com.example.demo.controller.UserController.createUser(..))")
    public void argsObjectPointCut() {}

    @Around("argsObjectPointCut()")
    public Object beforeArgsObjectPointCut(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("#ArgsAspect.beforeArgsObjectPointCut, 进入切面");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("#ArgsAspect.beforeArgsObjectPointCut, 切点中的第{}个参数{}", i, args[i]);
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            log.info("#ArgsAspect.beforeArgsObjectPointCut, 当前参数为, parameter: {}", parameter);
            Class<?> type = parameter.getType();
            log.info("#ArgsAspect.beforeArgsObjectPointCut, 参数类型为, type: {}", type);
            for (Field declaredField : type.getDeclaredFields()) {
                log.info("#ArgsAspect.beforeArgsObjectPointCut, 当前域为, declaredField: {}", declaredField);
                Nonnull annotation = declaredField.getAnnotation(Nonnull.class);
                if (Objects.nonNull(annotation)) {
                    log.info("#ArgsAspect.beforeArgsObjectPointCut, field: {} 存在注解 annotation: {}", declaredField, annotation);
                    declaredField.setAccessible(true);
                    declaredField.set(args[i], BigInteger.TEN);
                }
            }
            log.info("#ArgsAspect.beforeArgsObjectPointCut, 切点中的第{}个参数被修改为{}", i, args[i]);
        }

        Object proceed = joinPoint.proceed(args);

        Class<?> reObj = proceed.getClass();
        Field[] declaredFields = reObj.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            log.info("#ArgsAspect.beforeArgsObjectPointCut, 返回值当前域为, declaredField: {}", declaredField);
            I18n annotation = declaredField.getAnnotation(I18n.class);
            if (Objects.nonNull(annotation)) {
                log.info("#ArgsAspect.beforeArgsObjectPointCut, 返回值, field: {} 存在注解 annotation: {}", declaredField, annotation);
                declaredField.setAccessible(true);
                declaredField.set(proceed, "dapiaoliang");
            }
        }
        log.info("#ArgsAspect.beforeArgsObjectPointCut, 返回值被修改为, proceed: {}", proceed);

        return proceed;
    }
}
