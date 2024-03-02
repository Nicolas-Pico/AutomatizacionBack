# Proyecto de Automatización de Servicios con Serenity Screenplay y Rest Assured

Este repositorio contiene un proyecto de automatización de servicios web utilizando el patrón de diseño Screenplay de Serenity y Rest Assured para realizar pruebas en APIs RESTful.

## Descripción del Proyecto

El objetivo de este proyecto es automatizar pruebas de servicios web para garantizar su funcionalidad, rendimiento y seguridad. Se utiliza el patrón de diseño Screenplay para escribir pruebas de manera más legible, mantenible y escalable.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/java`: Contiene las clases y paquetes que representan la implementación de las capacidades y tareas del patrón Screenplay.
- `src/test/java`: Contiene las clases de pruebas utilizando Rest Assured para interactuar con los servicios RESTful y Serenity para gestionar y generar informes de pruebas.
- `src/test/resources`: Contiene archivos de configuración, como archivos de propiedades. features y datos de prueba.

## Configuración del Entorno

1. **Dependencias del Proyecto:**
   Asegúrate de que tu proyecto incluya las dependencias necesarias para Serenity Screenplay y Rest Assured en tu archivo `pom.xml` si estás utilizando Maven o `build.gradle` si estás utilizando Gradle.

2. **Configuración de Serenity:**
   Configura Serenity para generar informes de pruebas detallados y personalizados según tus necesidades. Puedes utilizar la anotación `@CucumberOptions` en tus clases de prueba para configurar las características de los informes.

3. **Configuración de Rest Assured:**
   Configura Rest Assured para establecer la base URI de tu servicio y otras configuraciones necesarias para tus pruebas.

## Ejecución de las Pruebas

1. **Ejecución desde la Línea de Comandos:**
   Ejecuta las pruebas utilizando Maven o Gradle desde la línea de comandos:
