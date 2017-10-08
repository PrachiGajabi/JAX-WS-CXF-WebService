package org.learning.globalgeatherservice;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.learning.globalgeatherservice.exception.CityNotFoundException;

/**
 * @author admin
 *
 */
@WebService(endpointInterface = "org.learning.globalgeatherservice.CityTemperature")
@HandlerChain(file="../../../../handler-chain.xml")
public class CityTemperatureImpl implements CityTemperature {

	@Override
	public final String getCityTemperature(final String cityName) throws CityNotFoundException {
		String temp = null;
		if ( cityName != null && "Sydney".equals(cityName) ) {
			temp = "15 Degree Celsius";
		} else {
			throw new CityNotFoundException("City name is not recognised");
		}
		return temp;		
	}

	@Override
	@WebMethod(exclude = true)
	public final String getRainDetails(final String cityName) {
		return "This operation is not implemented yet and that is why excluded from this service";
	}
}
