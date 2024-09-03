# Application-checkpoint

En java, la serialización es una poderosa herramienta, nos permite convertir nuestros objetos en streams de bytes, facilitando la tarea de guardarlos o enviarlos a traves de la red. Ademas, java nos permite obtener dichos objetos a su forma original a traves de la deserialización.

<br>

# Java Serialization
Para conseguir este comportamiento en nuestros objetos, debemos implementar la interface java.io.Serializable en la clase. Cuando nuestra clase implementa Serializable, el estado de nuestras instancias puede ser escrito y leido por ObjectOutputStram y ObjectInputStream.
Debemos prestar especial atención cuando nuestra clase posee atributos no serializables, como file handlers o conexiones a la red. Pues la serialización de dichos objetos puede no ser seguro o imposible de realizarlo de manera automática.

<br>

# Atributos transient y static
Al diseñar clases serializables, podemos tener atributos que no deben ser serializados, por seguridad o porque simplemente no es necesario. Para ello, podemos marcarlos como transient o static:

`transient`: sirve para excluir datos confidenciales o valores temporales de la serialización. Protege la información confidencial y evita guardar datos innecesarios.
<br>
`static`: dado que pertenecen a la clase y no a las instancias, los campos estáticos no se serializan de forma predeterminada. Sus valores se reinicializan cuando se deserializa un objeto.

<br> 

# El rol de serialVersionUID
**serialVersionUID** es un identificador único asignado a las clases serializables. Garantiza la compatibilidad durante la serialización y deserialización verificando que la versión de la clase que se deserializa coincide con la versión utilizada para la serialización. 
Es esencial para gestionar la compatibilidad entre diferentes versiones de clases y puedes declararlo explícitamente para controlar el comportamiento de serialización. Si no proporciona uno, Java lo genera automáticamente, lo que puede generar problemas si la definición
de la clase cambia entre serialización y deserialización.

Casos en los que debemos modificar el *serialVersionUID*

Cambios incompatibles (debe actualizar serialVersionUID):
* *Remover atributos*
* *Cambiar tipos de datos*
<br>

Cambios compatibles (no es necesario actualizar serialVersionUID, aunque ayuda a prevcenir problemas de compatibilidad):
* *Agregar nuevos atributos*

<br>

# Riesgos de seguridad

La principal preocupación de seguridad con la serialización de Java radica en la deserialización. Si nuestra aplicación recibe objetos maliciosos serializados, al deserializarlos, puede provocar una serie de violaciones de seguridad, que incluyen:

* *Ejecución remota de código (RCE)*: el atacante adquiere privilegios y control sobre el sistema, tras lo cual puede robar datos, instalar malware o interrumpir las operaciones.
* *Denegación de servicio (DoS)*: los objetos maliciosos pueden consumir recursos y bloquear la aplicación, impidiendo que los usuarios legítimos accedan a ella.
* *Exposición de datos*: si los datos confidenciales se serializan e interceptan, caen en manos de atacantes.

<br>

# Buenas prácticas

* **Control de versiones y compatibilidad**: Utilizar técnicas como serialVersionUID y métodos de serialización personalizados para mantener la compatibilidad entre diferentes versiones de su aplicación.
* **Campos** `transient`: utilizar transient para atributos que no deben serializarse. Esto evita que se conserve información confidencial o datos temporales.
* **Whitelist**: solo permita la deserialización de clases incluidas explícitamente en una lista de confianza. Esto evita que se ejecuten objetos inesperados o maliciosos.
* **WriteObject y readObject personalizados**: implemente métodos writeObject y readObject personalizados para controlar el proceso de serialización. Incluya su propia lógica de validación para evitar la deserialización de datos manipulados o no válidos.
* **API alternativas**: considere alternativas más seguras como JSON o XML para intercambiar objetos a través de redes o entre aplicaciones. A menudo son más seguros e interpolables

<br><br>

Fuente: https://medium.com/@chanakaanuruddha/serialization-in-java-best-practices-and-strategies-for-protecting-your-data-7fe82a8ea32b

# Resultados
Ilustraremos este comportamiento utilizando tres clases:
* `AplicationCheckpoint`: la clase principal
* `Champion`: sera nuestra clase que implementa Serializable
* `GameControl`: esta clase esta encargada de hacer upgrades a campeones, provocar un error durante la ejecución, guardar y cargar checkpoints cuando un error sea capturado.

<br>

![Captura 1](https://github.com/CristopherLodbrok117/application-checkpoint/blob/124a42e4ea8c9ee07e84cacccdb9a31c5c0b004f/checkpoint_1.png)

<br>

![Captura 2](https://github.com/CristopherLodbrok117/application-checkpoint/blob/124a42e4ea8c9ee07e84cacccdb9a31c5c0b004f/checkpoint%202.png)

