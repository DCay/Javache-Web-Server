# Javache Web Server Official Changelog

## [v. 0.0.1]

### Removed:

*  Removed the _resources_ folder which was part of the application logic on the **Server**.
*  Removed all _manual parsing_ from the **RequestHandler**.
*  Removed all _hardcoded values_ from the **RequestHandler**.
*  Removed some _unnecessary_ or _inappropriately placed_ constants from the **WebConstants** class.

### Added:

*  Added a **ConnectionHandler** which will handle with the _Client Socket_ logic.
*  Added several new constants to the WebConstants class.
*  Added several new constants which are placed in their corresponding classes / interfaces.
*  Added a **Reader** which exposes a single static method for handling the _InputDataStream_ from the **Client Socket**.
*  Added a **Writer** which exposes a single static method for handling the _OutputDataStream_ from the **Client Socket**.
*  Added a basic **HTML Encoder** which exposes a single static method for encoding HTML special characters.
*  Added an _interface_ for a **HTTP Request**.
*  Added an _interface_ for a **HTTP Response**.
*  Added an _enumeration_ for the **Response Lines** to the _**HttpResponse** interface_.
*  Added an _interface_ for a wrapper of the **HTTP Request** and **HTTP Response**.
*  Added an _implementation_ of the _**HttpRequest** interface_.
*  Added an _implementation_ of the _**HttpResponse** interface_.
*  Added an _implementation_ of the _**HttpContext** interface_.
*  Added an _enumeration_ for the **HTTP Status**.

### Changed:

*  The **Server** files are now in a separate folder in a package - _**org.softuni.javache**_.
*  The **Server** is now _initialized_ and _started_ from a **StartUp** class which is _positioned_ in the package - _**org.softuni**_
*  The **Server** now _initializes_ a **ConnectionHandler** and a **RequestHandler** upon _client connection_.
   *  The **Client Socket** is _injected_ to the **ConnectionHandler**.
   *  The **RequestHandler** is _injected_ to the **ConnectionHandler**.
*  The **ConnectionHandler** extracts the _InputDataStream_ and the _OutputDataStream_ from the **Client Socket**.
*  The **ConnectionHandler** uses the **Reader** to extract a _String representation_ of the **Request**.
   *  The _String representation_ is then _passed_ to the **RequestHandler**.
*  The **RequestHandler returns a _byte[] array representation_ of the full **Response**.
   *  The **ConnectionHandler** uses the **Writer** to write the _binary data_ to the _OutputDataStream_ of the **Client Socket**.

### Closed Issues & Fixed Errors:

*  [Issue #1](https://github.com/DCay/Javache-Web-Server/issues/1)
*  [Issue #2](https://github.com/DCay/Javache-Web-Server/issues/2)
*  [Issue #3](https://github.com/DCay/Javache-Web-Server/issues/3)
*  [Issue #4](https://github.com/DCay/Javache-Web-Server/issues/4)
*  [Issue #5](https://github.com/DCay/Javache-Web-Server/issues/5)
*  [Issue #6](https://github.com/DCay/Javache-Web-Server/issues/6)
*  [Issue #7](https://github.com/DCay/Javache-Web-Server/issues/7)
*  [Issue #8](https://github.com/DCay/Javache-Web-Server/issues/8)
*  [Issue #9](https://github.com/DCay/Javache-Web-Server/issues/9)
*  [Issue #13](https://github.com/DCay/Javache-Web-Server/issues/13)
