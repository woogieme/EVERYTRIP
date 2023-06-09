import Vue from "vue";

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faHeart as fasHeart } from "@fortawesome/free-solid-svg-icons";
import { faHeart as farHeart } from "@fortawesome/free-regular-svg-icons";
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'


library.add(faUserSecret)
library.add(fasHeart, farHeart);

Vue.component("font-awesome-icon", FontAwesomeIcon);
