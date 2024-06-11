/**
	@DeleteMapping("/users/{id}")
	public void DeleteById(@PathVariable int id) {
		service.DeleteById(id);
	}
	
	
	
	@GetMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		service.DeleteById(id);

	}
	*/
