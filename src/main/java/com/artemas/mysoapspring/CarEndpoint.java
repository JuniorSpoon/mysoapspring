package com.artemas.mysoapspring;


import com.artemas.mysoapspring.gen.GetCarRequest;
import com.artemas.mysoapspring.gen.GetCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarEndpoint {

    private static final String NAMESPACE_URI = "http://www.artemas.com/mysoapspring/gen";

    private CarRepository carRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carRepository.findCar(request.getModel()));

        return response;
    }
}
