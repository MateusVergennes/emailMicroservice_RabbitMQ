# 📧 Email Service Microservice

This microservice is responsible for sending welcome emails to users who register through the User Registration Microservice. It utilizes RabbitMQ to receive messages and Gmail's SMTP for sending emails. 

![1](https://github.com/user-attachments/assets/1491e0d5-d4d4-4df8-b605-bb7daacfe1a7)
![2](https://github.com/user-attachments/assets/f83edd8a-cf5d-467a-a59b-df2925011497)
![3](https://github.com/user-attachments/assets/e2ec85f2-dd82-48fb-972c-f3fc6eb2fd13)

## 🚀 Technologies

- **Java** ☕
- **Spring Boot** 🌱
  - Spring Web 🌐
  - Spring AMQP 🐇
  - Spring Mail 📧
- **RabbitMQ** 🐰
- **CloudAMQP** ☁️
- **Maven** 📦

## 💡 Key Features

- **Email Sending**: Sends personalized welcome emails to users after registration.
- **Message Queue**: Listens to messages from RabbitMQ for incoming user registration events.
- **Error Handling**: Includes proper error handling for email sending failures.

## 🛠️ Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-username/email-service.git
cd email-service
```

### 2. Install dependencies

```bash
mvn clean install
```

### 3. Configure the environment variables

Make sure to configure the following environment variables:

- `RABBITMQ_URL`: CloudAMQP connection URL 🐇
- `MAIL_USERNAME`: Gmail SMTP username 📧
- `MAIL_PASSWORD`: Gmail SMTP password 🔑

You can add them to your `.env` file:

```bash
RABBITMQ_URL=amqps://your-cloudamqp-url
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-email-password
```

### 4. Run the application

```bash
mvn spring-boot:run
```

## 📬 Message Queue

This microservice listens to the RabbitMQ queue for messages containing user registration details. The message structure is as follows:

```json
{
  "userId": 123,
  "email": "johndoe@example.com",
  "message": "Welcome to our platform!"
}
```
## ✉️ Email Sending Logic

Upon receiving a message, the email service uses the provided email address to send a welcome email:

- **Subject**: Welcome to Our Platform!
- **Body**:

## ✉️ Email Sending Logic

The Email Service listens for messages on the RabbitMQ queue, which contain user registration information. When a message is received, the service creates an `EmailModel` object and uses it to send a welcome email to the user.

### Email Process Flow

1. **Receive Message**: The service listens to the RabbitMQ queue for incoming user registration messages.
2. **Create Email Model**: A new `EmailModel` instance is created from the incoming data, which includes the recipient's email address, subject, and message body.
3. **Send Email**: 
   - The `JavaMailSender` is utilized to send the email.
   - The email's sending date is recorded, and the status is updated accordingly.
   - In case of a failure during the email sending process, the status is updated to indicate an error.
4. **Save Email Record**: After attempting to send the email, the record is saved to the database, allowing for tracking and debugging.

### Sample Email Content

The welcome email is sent with the following components:

- **To**: Recipient's email address.
- **Subject**: A personalized subject line, such as "Welcome to Our Platform!"
- **Text**: A brief message welcoming the user, including a thank you note for registration.

The entire process ensures that each user receives a confirmation email upon their registration, enhancing their experience with our platform.

## ✅ Error Handling

The service includes robust error handling for various scenarios, including invalid email addresses and SMTP connection issues. If an error occurs during email sending, the email's status is updated to reflect the error condition, allowing for easy tracking and resolution.

## 📋 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
