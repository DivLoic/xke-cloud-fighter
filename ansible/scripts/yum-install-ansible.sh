#!/usr/bin/env bash

# TODO: parameterize the gcloud user name
ZSH_URL="https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh"

yum install zsh -y
yum install git -y
yum install tree -y
chsh -s "$(which zsh)" loicmdivad
su - loicmdivad -s /bin/bash -c "$(curl -fsSL ${ZSH_URL})"
su - loicmdivad -s /bin/bash -c "sed -i '/^ZSH_THEME=/c\ZSH_THEME=\"agnoster\"' ~/.zshrc"

yum install epel-release -y
yum install ansible -y

su - loicmdivad -s /bin/bash -c "ssh-keygen -t rsa -q -N '' -f ~/.ssh/id_rsa"
su - loicmdivad -s /bin/bash -c "git clone -b work https://github.com/DivLoic/xke-cloud-fighter.git"