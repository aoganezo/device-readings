package bright.device.reader.controller;

import bright.device.reader.model.CumulativeCountResponse;
import bright.device.reader.model.DeviceReadingRequest;
import bright.device.reader.model.TimestampResponse;
import bright.device.reader.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device/readings")
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	/**
	 * Pushes device reading data to tne h2 database; returns an HTTP 400 and logs it upon failure.
	 *
	 * @param deviceReadings - a list of readings for a given device.
	 * @return ResponseEntity, HTTPStatus
	 */
	@PostMapping
	public ResponseEntity postDeviceReadings(@RequestBody DeviceReadingRequest deviceReadings) throws Exception {
		try {
			deviceService.updateDeviceReadings(deviceReadings);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("An error occurred while processing your request.");
		}
	}

	/**
	 * Retrieves the device if it exists in h2 and returns the latest timestamp, otherwise returns an Exception and logs it.
	 *
	 * @param deviceId - A string representing the UUID for the device.
	 * @return TimestampResponse - an object containing the latest timestamp.
	 */
	@GetMapping("/{deviceId}/latest/timestamp")
	public ResponseEntity getLatestTimestampForDevice(@PathVariable String deviceId) throws Exception {
		try {
			return ResponseEntity.ok().body(deviceService.getLatestTimestamp(deviceId));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("An error occurred while processing your request.");
		}
	}

	/**
	 * Retrieves the device if it exists in h2 and returns the count of records, otherwise returns an Exception and logs it.
	 *
	 * @param deviceId - A string representing the UUID for the device.
	 * @return CumulativeCountResponse - an object containing the cumulative count of records
	 */
	@GetMapping("/{deviceId}/count")
	public ResponseEntity getReadingCountForDevice(@PathVariable String deviceId) {
		try {
			return ResponseEntity.ok().body(deviceService.getReadingCount(deviceId));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("An error occurred while processing your request.");
		}
	}
}