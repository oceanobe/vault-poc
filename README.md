## 1) Prerequisites
Before starting with the project setup, ensure you have the following prerequisites installed:

- **Java 21**
- **Maven**
- **HashiCorp Vault in a Docker container**: HashiCorp Vault is used to manage and access secrets. You'll run Vault in a Docker container for local development. Ensure Docker is installed and running on your machine.

## 2) Vault Setup
### a) Run Vault in a Docker Container
To run HashiCorp Vault in a Docker container, use the following commands:

1. Pull the Vault Docker image:
    ```bash
    docker pull vault:latest
    ```

2. Run the Vault container:
    ```bash
    docker run -d --name vault -p 8200:8200 -e 'VAULT_DEV_ROOT_TOKEN_ID=root' -e 'VAULT_ADDR=http://127.0.0.1:8200' hashicorp/vault:latest
    ```

    This will start Vault in development mode with the root token `root` for access. You can access Vault at `http://localhost:8200`.

### b) Create a Secret using command line
To create a secret in Vault, follow these steps:

1. Access the container
    ```bash
    docker exec -it vault bin/sh
    ```

2. Export the root token
    ```bash
    export VAULT_TOKEN=root
    ```

3. Create a secret using the vault util:
    ```bash
    vault kv put secret/payment-gateway api-key="super-secret-api-key"
    ```

    This stores the secret under the path `secret/payment-gateway`.


## 3) Build & Run
To build and run the Spring Boot project, use the following commands:

1. Build the project:
    ```bash
    mvn clean install
    ```

2. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

3. Once the application is running, it should be able to access secrets from Vault using the configurations you set up earlier.

## 4) Access the Test Endpoint
Once the project is running, you can access the test endpoint to verify that the application is retrieving secrets correctly from Vault.
```bash
http://localhost:8080/payment
```
