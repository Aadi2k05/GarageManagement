# Garage Management

A Java-based application for managing garage operations, including vehicle tracking, service management, and customer records.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Vehicle Management**: Track and manage vehicle information
- **Service Tracking**: Record and manage garage services
- **Customer Management**: Maintain customer records and history
- **Inventory Management**: Keep track of spare parts and supplies
- **Reporting**: Generate service and revenue reports

## Prerequisites

- Java 8 or higher
- Maven (for dependency management)
- Git (for version control)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/Aadi2k05/GarageManagement.git
cd GarageManagement
```

2. Navigate to the project directory:
```bash
cd GarageManagement
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn exec:java
```

## Usage

1. **Launch the application** - Start the application using the commands above
2. **Main Menu** - Navigate through the menu options to:
   - Add/view/update vehicle records
   - Manage customer information
   - Record and track services
   - Manage inventory
   - View reports

## Project Structure

```
GarageManagement/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/garage/
│   │           ├── models/
│   │           ├── services/
│   │           ├── ui/
│   │           └── Main.java
│   └── test/
├── pom.xml
└── README.md
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

---

For more information or questions, please open an issue in the repository.
