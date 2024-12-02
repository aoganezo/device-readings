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
	 * Retrieves the document if it exists in h2, otherwise returns an Exception and logs it.
	 *
	 * @param deviceReadings - a list of readings for a given device.
	 * @return ResponseEntity, HTTPStatus
	 */
	@PostMapping
	public ResponseEntity postDeviceReadings(@RequestBody DeviceReadingRequest deviceReadings) throws Exception {
		return ResponseEntity.ok().build();
		// TODO: Error Handling. Store data.
	}

	/**
	 * Retrieves the device if it exists in h2 and returns the latest timestamp, otherwise returns an Exception and logs it.
	 *
	 * @param deviceId - A string representing hte UUID for the device.
	 * @return TimestampResponse - an object containing the latest timestamp.
	 */
	@GetMapping("/{deviceId}/latest/timestamp")
	public ResponseEntity<TimestampResponse> getLatestTimestampForDevice(@PathVariable String deviceId) throws Exception {
		return ResponseEntity.ok().body(deviceService.getLatestTimestamp(deviceId));
		// TODO: Error Handling
	}

	/**
	 * Retrieves the device if it exists in h2 and returns the count of records, otherwise returns an Exception and logs it.
	 *
	 * @param deviceId - A string representing hte UUID for the device.
	 * @return CumulativeCountResponse - an object containing the cumulative count of records
	 */
	@GetMapping("/{deviceId}/count")
	public ResponseEntity<CumulativeCountResponse> getReadingCountForDevice(@PathVariable String deviceId) throws Exception {
		return ResponseEntity.ok().body(deviceService.getReadingCount(deviceId));
		// TODO: Error Handling
	}
}