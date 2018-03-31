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

module "zookeeper101" {
  source = "./terraform/zookeeper"
  myid = "101"
}

module "zookeeper102" {
  source = "./terraform/zookeeper"
  myid = "102"
}

module "zookeeper103" {
  source = "./terraform/zookeeper"
  myid = "103"
}