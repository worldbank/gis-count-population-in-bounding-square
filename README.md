# Study Area Characteristics

This application calculates the number of agents within an axis-aligned bounding square centered on a given location and of a given length.

# Requirements

- SBT 1.0.3
- Java 8

# Use

At the SBT prompt, run the following command:

```
runMain org.ifc.figssamel.drc.Main /path/to/areas-location-file.csv /path/to/agents-location-file.csv /path/to/output-file.csv edge-length-in-km,edge-length-in-km

// Example, for 0.5 km and 0.25 km box edge sizes
runMain org.ifc.figssamel.drc.Main "~/DRC/plotting/data/FINCA- areas of interes with GPS.csv" "~/DRC/plotting/data/GPS Data.csv" "~/DRC/plotting/data/results2.csv" 0.250,0.5
```

The output would be something like the following:

```csv
area_name,Any_within_0.25km,number_within_0.25km,Any_within_0.5km,number_within_0.5km
Ngaliema (Delcaux)_Delvaux_2,Y,1,Y,2
Ngaliema (DGC)_DGC_3,N,0,Y,25
Mont ngafula_Triangle Cité verte_4,N,0,N,0
Kasa-vubu_Gambela_5,N,0,N,0
Lemba_Boulevard Salongo_6,Y,6,Y,6
```

The following image illustrates the objective. The purple squares are 500m by 500m bounding boxes centered at survey area points. The green markers mark agent locations. This application gives counts of the number of agents within each bounding square of a given size.

![Map of DRC with survey and agent locations](https://user-images.githubusercontent.com/2116061/33957947-156cc588-e011-11e7-9505-c2a0b8443fef.png)
