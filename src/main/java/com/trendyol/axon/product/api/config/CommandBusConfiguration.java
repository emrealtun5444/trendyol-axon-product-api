package com.trendyol.axon.product.api.config;

import com.trendyol.axon.product.api.command.interceptors.CommandInterceptor;
import com.trendyol.axon.product.api.common.Constants;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.PropagatingErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandBusConfiguration {
    private final CommandInterceptor commandInterceptor;

    @Autowired
    public void registerCommandInterceptor(CommandBus commandBus) {
        commandBus.registerDispatchInterceptor(commandInterceptor);
    }
    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler(Constants.Group.PRODUCT, conf -> PropagatingErrorHandler.instance());
    }
}
