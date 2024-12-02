package bright.device.reader.controller;

import bright.device.reader.model.CumulativeCountResponse;
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
	 * A temporary controller
	 * 
	 * @return ResponseEntity(null, HTTPStatus)
	 */
	@PostMapping
	public ResponseEntity postDeviceReadings() throws Exception {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{deviceId}/latest/timestamp")
	public ResponseEntity<TimestampResponse> getLatestTimestampForDevice(@PathVariable String deviceId) throws Exception {
		return ResponseEntity.ok().body(deviceService.getLatestTimestamp(deviceId));
	}

	@GetMapping("/{deviceId}/count")
	public ResponseEntity<CumulativeCountResponse> getReadingCountForDevice(@PathVariable String deviceId) throws Exception {
		return ResponseEntity.ok().body(deviceService.getReadingCount(deviceId));
	}
}