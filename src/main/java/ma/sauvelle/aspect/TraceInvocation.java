package ma.sauvelle.aspect;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class TraceInvocation {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TraceInvocation.class);

    @Pointcut("execution(* ma.sauvelle.services.ProduitService..*(..))")
    public void traceInvocationPointcut() { }

    @Pointcut("execution(* ma.sauvelle.services.MyUserDetailsService..*(..))")
    public void traceMatierePointcut() { }

    @Pointcut("execution(* ma.sauvelle.services.DiscountService..*(..))")
    public void traceOriginePointcut() { }

    @Around("traceInvocationPointcut() || traceMatierePointcut() || traceOriginePointcut()")
    public Object afficherTrace( ProceedingJoinPoint joinpoint) throws Throwable {
        String nomMethode = joinpoint.getTarget().getClass().getSimpleName() + "."
                + joinpoint.getSignature().getName();
        Object obj =joinpoint.proceed();
//        }
        logger.info(nomMethode);
        return obj;
    }


}
