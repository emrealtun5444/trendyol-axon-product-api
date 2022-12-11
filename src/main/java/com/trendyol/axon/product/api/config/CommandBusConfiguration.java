package com.trendyol.axon.product.api.config;

import com.trendyol.axon.product.api.command.interceptors.CommandInterceptor;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandBus;
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
}
