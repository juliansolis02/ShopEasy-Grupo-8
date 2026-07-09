# ShopEasy-Grupo-8

## Descripción

ShopEasy es una plataforma web de comercio electrónico orientada a pequeñas y medianas empresas, desarrollada con Spring Boot. El sistema permite la administración de productos y categorías, así como un flujo básico de compra que incluye catálogo, carrito de compras, checkout e historial de compras.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap 5
- Hibernate / JPA
- MySQL
- GitHub

---

## Funcionalidades implementadas

### Módulo Administrador

- Dashboard administrativo.
- Gestión de categorías (CRUD).
- Gestión de productos (CRUD).
- Control de stock.

### Módulo Cliente

- Catálogo de productos.
- Búsqueda por nombre.
- Filtro por categoría.
- Vista de detalle del producto.
- Carrito de compras.
- Checkout.
- Confirmación de compra.
- Historial de compras.

---

## Base de Datos

El proyecto utiliza MySQL junto con Hibernate/JPA para la persistencia de la información.

En la carpeta **database** se incluyen:

- `shopeasy_db.sql` → Script con datos de prueba.
- `README_BD.txt` → Instrucciones para configurar la base de datos.

---

## Configuración

Antes de ejecutar el proyecto, cada integrante deberá configurar sus credenciales de MySQL en:

```text
src/main/resources/application.properties
```

Posteriormente deberá ejecutar el script ubicado en:

```text
database/shopeasy_db.sql
```

---

## Integrantes

- FONSECA SILES ESTEBAN JAVIER
- RUIZ CRUZ LORENZO ANTONIO
- SOLIS MURILLO JOSE JULIAN

---

## Estrategia de ramas

- `main`: versión estable del proyecto.
- `develop`: integración de funcionalidades.
- `feature/nombre-funcionalidad`: desarrollo de nuevas funcionalidades.
- `hotfix/nombre-correccion`: corrección de errores.

---

## Estado del proyecto

Actualmente el proyecto corresponde al **Avance 2**, donde se ha implementado aproximadamente el **50% de las historias de usuario**, incluyendo la administración de productos y categorías, el catálogo de productos, el carrito de compras, el proceso de checkout, el historial de compras y el dashboard administrativo.

---

## Notas

Este proyecto fue desarrollado con fines académicos para el curso de Ingeniería en Sistemas, aplicando una arquitectura en capas con Spring Boot, Hibernate, Thymeleaf y MySQL.
