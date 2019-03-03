#Importando libreria para graficar
import matplotlib.pyplot as plot
import numpy as np

        
tipos_maps = ("Hash Map","Tree Map","LinkedHash Map")
num_maps = len(tipos_maps)
bar_width = 0.35
opacity = 0.8


plot.figure()

#Grafica del tiempo que tarda en mostrar los datos

plot.subplot(2,2,1)

tiempos = [1827,2081,1860]
tiempos_sinTrampa = [1086,1059,1089] 

#plot.bar(np.arange(num_maps),tiempos,align='center', alpha=0.5)
plot.bar(np.arange(num_maps), tiempos, bar_width,alpha=opacity,color='b',label='Todos')
plot.bar(np.arange(num_maps) + bar_width, tiempos_sinTrampa, bar_width,alpha=opacity,color='g',label='Sin C. Trampa')

plot.grid(True, linewidth=0.5,color='#ff0000', linestyle='-')

plot.xticks(np.arange(num_maps), tipos_maps)
plot.title("Mostrando Datos - Todas las Cartas")
plot.xlabel('Map')
plot.ylabel('Tiempo (ms)')
plot.title('Tiempo Despliegue Map')




# Grafica del tiempo que tarda en ordenar los datos
plot.subplot(2,2,2)

tiempos = [43.7,43.9,55.8]
tiempos_sinTrampa = [33,23.9,44.8]

#plot.bar(np.arange(num_maps),tiempos,align='center', alpha=0.5)
plot.bar(np.arange(num_maps), tiempos, bar_width,alpha=opacity,color='b',label='Todos')
plot.bar(np.arange(num_maps) + bar_width, tiempos_sinTrampa, bar_width,alpha=opacity,color='g',label='Sin C. Trampa')


plot.grid(True, linewidth=0.5,color='#ff0000', linestyle='-')

plot.xticks(np.arange(num_maps), tipos_maps)
plot.title("Ordenando Datos")
plot.xlabel('Map')
plot.ylabel('Tiempo (ms)')
plot.title('Tiempo Ordenado Map')

# Grafica del tiempo que tarda en cargar los datos
plot.subplot(2,2,3)

tiempos = [1886,1888,1663]
tiempos_sinTrampa = [1617,1520,1510]

#plot.bar(np.arange(num_maps),tiempos,align='center', alpha=0.5)
plot.bar(np.arange(num_maps), tiempos, bar_width,alpha=opacity,color='b',label='Todos')
plot.bar(np.arange(num_maps) + bar_width, tiempos_sinTrampa, bar_width,alpha=opacity,color='g',label='Sin C. Trampa')

plot.grid(True, linewidth=0.5,color='#ff0000', linestyle='-')

plot.xticks(np.arange(num_maps), tipos_maps)
plot.title("Cargando Datos")
plot.xlabel('Map')
plot.ylabel('Tiempo (ms)')
plot.title('Tiempo Carga a Map')



#mostramos la grafica
plot.show()
