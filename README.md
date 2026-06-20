# Test automation framework for API automation built on top of Playwright with Java

This test automation framewework serves as a single framework to create both UI and API automated test cases.
Web Application Under Test - https://www.saucedemo.com/
API Application Under Test - https://api.instantwebtools.net//v1/airlines

ConfigManager → configuration
ApiContextManager → Playwright API lifecycle
BookingClient → HTTP communication
BookingService → business workflows
BookingRequest/Response → DTOs
BookingData → test data
JsonUtils → serialization/deserialization
BookingTest → assertions