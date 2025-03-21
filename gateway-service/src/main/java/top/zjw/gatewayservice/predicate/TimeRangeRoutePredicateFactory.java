package top.zjw.gatewayservice.predicate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class TimeRangeRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeRangeRoutePredicateFactory.Config> {

    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";

    public TimeRangeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                LocalTime now = LocalTime.now();
                return now.isAfter(config.getStartTime()) && now.isBefore(config.getEndTime());
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("Time Range: %s to %s", config.getStartTime(), config.getEndTime());
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.unmodifiableList(List.of(START_TIME, END_TIME));
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        @NotNull
        private LocalTime startTime;
        @NotNull
        private LocalTime endTime;
    }
}