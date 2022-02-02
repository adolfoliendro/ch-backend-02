package com.aliendro.controller.message;

import com.aliendro.controller.exception.ApiRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/controller")
public class MessageController {

    Logger logger = LogManager.getLogger(MessageController.class);

    @GetMapping("/example")
    public String getExample() {
        logger.info("GET Request recibido string");
        return "Ejemplo de respuesta";
    }

    @GetMapping("/messages/all")
    public List<Message> getMessagesAll() {
        logger.info("GET Request recibido string");
        return dataMessages();
    }

    @GetMapping("/messages")
    public List<Message> getMensajesByDescription(@RequestParam String description) {
        logger.info("GET obtener mensajes que sean iguales a la descripción");
        var msjFiltered = dataMessages().stream()
                .filter(mensajes -> mensajes.getDescription().equalsIgnoreCase(description));
        return msjFiltered.collect(Collectors.toList());
    }

    @GetMapping("/messages/{id}")
    public Message getMensajeById(@PathVariable Long id) throws ApiRequestException {
        logger.info("GET obtener mensaje por el id");

        if (id <= 0) throw new ApiRequestException("El identificador del mensaje debe ser mayor a 0");

        var msjFiltered = dataMessages().stream()
                .filter(messages -> Objects.equals(messages.getId(), id));
        return msjFiltered.findFirst().orElseThrow(() -> new ApiRequestException("No existe el mensaje"));
    }

    private List<Message> dataMessages() {
        return List.of(
                new Message(1L, "Impar"),
                new Message(2L, "Par"),
                new Message(3L, "Impar"),
                new Message(4L, "Par"),
                new Message(5L, "Impar"),
                new Message(6L, "Par"),
                new Message(7L, "Impar")
        );
    }

}
