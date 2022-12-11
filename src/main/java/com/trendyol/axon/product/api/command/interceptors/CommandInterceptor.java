package com.trendyol.axon.product.api.command.interceptors;

import com.trendyol.axon.product.api.command.CreateProductCommand;
import com.trendyol.axon.product.api.common.exception.BusinessException;
import com.trendyol.axon.product.api.core.repository.ProductLookupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
    Logger LOGGER = LoggerFactory.getLogger(CommandInterceptor.class);

    private final ProductLookupRepository productLookupRepository;

    @Override
    public CommandMessage<?> handle(CommandMessage<?> message) {
        return MessageDispatchInterceptor.super.handle(message);
    }

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
            List<? extends CommandMessage<?>> messages) {
        return (index, command) -> {
            LOGGER.info(String.format("Command received: %s", command.getPayloadType()));
            if (CreateProductCommand.class.equals(command.getPayloadType())) {
                final var createProductCommand = (CreateProductCommand) command.getPayload();
                final var isBarcodeExists = productLookupRepository.existsProductByBarcode(createProductCommand.getBarcode());
                if (isBarcodeExists) {
                    throw new BusinessException(String.format("Product with %s barcode number already exists", createProductCommand.getBarcode()));
                }
            }
            return command;
        };
    }
}
