resource "google_compute_instance" "broker101" {

  name = "broker101"
  tags = [ "broker" ]
  zone = "europe-west1-d"
  machine_type = "n1-standard-2"
  boot_disk {
    initialize_params {
      image = "centos-7"
    }
  }
  network_interface {
    network = "default"
    access_config { }
  }
}