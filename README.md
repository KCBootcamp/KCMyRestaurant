# KCMyRestaurant

Esta applicación Android, es una herramienta para la gestión de los pedidos de un restaurante, teniendo a mano información vital como puede ser el número de comensales en cada mesa, los platos pedidos por una mesa, el estado en el se encuentra el pedido de una mesa, los alérgenos de cada uno de los platos, etc. Para dar este soporte, la app dispone de un menú inicial del cual se puede acceder a tres distintas áreas: Alégnenos, Platos y Mesas.

Inicialmente se hace una carga de los platos con una llamada al servidor y se definen las mesas del restaurante

##Alérgenos
La sección de Alergénos es una sección informativa de los distitntos alérgenos que puede llevar un plato, en esta sección se listan los posibles alégenos (no clickables) y los iconos utilizado en la App para referirse a ellos.

##Platos
En esta sección se listan los platos que se encuentran en el menú del restaurante. Además de los platos se ofrece información relevante como los alégenos que contiene o el precio del mismo. Al pulsar sobre un plato (clickable) se muestra un detalle del mismo en el que se despliega tanto la infromación ya descrita anteriormente como una descripción del plato.

La vista en la que se muestra el detalle puede variar en función del tamaño y la orientación del dispositivo. El detalle también ofrece la posibilidad del uso del gesto swipe para cambiar de plato.

##Mesas
Esta es la sección más compleja, en ella primero se listan todas las mesas y se permite que se configure los parámetros de cada una de ellas. Para ello, se debe mantener pulsada una mesa (long click) y aparecerá una ventana que permitirá definir el número de comensales y el estado del pedido de la mesa.

Por otro lado, con un simple selección de la mesa (click) se permite al usuario acceder al listado de platos pedidos por esa mesa. A su vez esa vista con el listado tiene un botón para poder añadir más platos al pedido, para ello se accede a la vista de platos. Por otro lado, en esta misma vista del listado de platos del pedido se puede eliminar un plto del pedido manteniendolo pulsado (long click).

Finalmente, desde el botón superior derecho se puede acceder a la cuenta del pedido para ver lo que se lleva y el total del precio.

##Adaptación de vistas
Muchas de las pantallas se adaptan según el tamañano y la orientación del dispositivo puediendo modificar el comportamiento de la App.
