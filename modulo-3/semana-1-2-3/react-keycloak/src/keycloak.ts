import Keycloak from 'keycloak-js';


const keycloak = Keycloak({
  url: 'https://training.dev.delivery/auth/',
  realm: 'final-sample',
  clientId: 'front-sample',
});

export default keycloak;

