package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // basePackages -> 컴포넌트 스캔을 시작할 위치 지정, 하위 패키지 모두 탐색
        // basePackages 생략하면 디폴트로 hello.core (ComponentScan 위치)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 기존 예제 코드를 유지하기 위해 설정 정보를 스캔 대상에서 제외
)
public class AutoAppConfig {
}
