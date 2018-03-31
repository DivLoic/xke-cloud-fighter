provider "google" {
  credentials = "${file(".terraform/gcp-credentials.json")}"
  project     = "cloud-fighter"
  region      = "europe-west1"
}

resource "google_compute_instance" "edge101" {

  name = "edge101"
  tags = [ "edge" ]
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
  metadata_startup_script = "${file("./ansible/scripts/yum-install-ansible.sh")}"
}

resource "google_compute_instance" "zookeeper101" {

  name = "zookeeper101"
  tags = [ "zookeeper" ]
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