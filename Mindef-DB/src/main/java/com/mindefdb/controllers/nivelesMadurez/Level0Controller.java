package com.mindefdb.controllers.nivelesMadurez;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.examples.RequestDTO;
import com.mindefdb.dtos.examples.ResponseDTO;

@RestController
public class Level0Controller {
    @PostMapping("/api/service")
    public ResponseDTO handleRequest(@RequestBody RequestDTO request) {
        switch (request.getAction()) {
            case "GET_USER":
                return getUserResponse(request);
            case "CREATE_USER":
                return createUserResponse(request);
            case "GET_ORDER":
                return getOrderResponse(request);
            default:
                throw new IllegalArgumentException("Unknown action");
        }
    }

	private ResponseDTO getOrderResponse(RequestDTO request) {
		ResponseDTO respuesta = new ResponseDTO();
		respuesta.setData("Algun dato de la Orden");
		respuesta.setCode(1);
		
		return respuesta;
	}

	private ResponseDTO createUserResponse(RequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseDTO getUserResponse(RequestDTO request) {
		ResponseDTO respuesta = new ResponseDTO();
		respuesta.setData("Dato de algun usuario");
		respuesta.setCode(1);
		
		return respuesta;
	}
}