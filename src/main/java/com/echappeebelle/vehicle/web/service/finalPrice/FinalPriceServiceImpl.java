package com.echappeebelle.vehicle.web.service.finalPrice;

import com.echappeebelle.vehicle.web.model.finalPrice.FinalPrice;
import com.echappeebelle.vehicle.web.model.vehicle.TwoWheeler;
import com.echappeebelle.vehicle.web.model.vehicle.UtilityVehicle;
import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinalPriceServiceImpl implements FinalPriceService {

    public int calculateFinalPrice(FinalPrice finalPrice) {
        Vehicle vehicle = null;

        try {
            EurekaClient eurekaClient = null;
            RestTemplate restTemplate = new RestTemplate();

            Application application = eurekaClient.getApplication("ECHAPPEEBELLEVEHICLE");
            InstanceInfo instanceInfo = application.getInstances().get(0);
            String baseUrl = instanceInfo.getHomePageUrl();

            System.out.println(baseUrl);

            ResponseEntity<Vehicle> vehicleResponse = restTemplate.getForEntity(baseUrl + "vehicles/" + finalPrice.getVehicleId(), Vehicle.class);
            vehicle = vehicleResponse.getBody();
            if (vehicle == null) {
                throw new Exception("Le véhicule n'éxiste pas");
            }




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int nbKM = finalPrice.getNbKilometers();
        int basePriceInCents = vehicle.getBookingPriceInCents();
        int pricePerKilometersInCents = vehicle.getPricePerKilometerInCents();


        if (vehicle.getType().equals("Car")) {
            return basePriceInCents + (pricePerKilometersInCents * nbKM);
        } else if (vehicle.getType().equals("TwoWheeler")) {
            int displacement = ((TwoWheeler)vehicle).getDisplacementInCm3();
            return (int) (basePriceInCents + (displacement * 0.001 * pricePerKilometersInCents * nbKM));
        } else if (vehicle.getType().equals("UtilityVehicle")) {
            int volume = ((UtilityVehicle)vehicle).getVolumeInM3();
            return (int) (basePriceInCents + (volume * 0.05 * pricePerKilometersInCents * nbKM));
        } else {
            return 0;
        }
    }
}
