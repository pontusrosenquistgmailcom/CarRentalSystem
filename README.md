# CarRentalSystem
Small console application that manages vehicle assets for a rental car business.

VehicleAssets superclass
PassengerCar, Truck, Motorcycle subclasses

bookVehicle();
pickUpVehicle();
returnVehicle();

newVehicle submenu


# Planeringsmall — Projektskiss

Fyll i denna mall innan ni börjar koda. Skissen är ett första utkast, inte ett facit — det är både normalt och förväntat att klassnamn och struktur ändras när ni väl börjar implementera. Spara den ifyllda mallen som README i er första commit, tillsammans med namn på den/de som jobbar i projektet.

## Projektidé
Project member: Pontus Rosenquist

Car rental system. Console application that manages cars, trucks and bikes.
Add vehicles, book them, lend them out, return them.
Manage your vehicle assets with maintenance module.
Find your perfect ride with CRS! (``C``ar ``R``ental ``S``oftware, ``Cool Ride System``)


## Superklass

- Namn: VehicleAssets
- Gemensamma fält: vehicleID, licenceNumber, manufacturer, model, boolean isBooked, boolean isInUse, 
- Gemensamma metoder: displayVehicleInfo(), newVehicle(), deleteVehicle, bookVehicle, retrieveVehicle, returnVehicle, isReserved(), inUse(),

## Subklasser (minst tre)

1. PassengerCar displayVehicleInfo(), numberOfSeats, colour, newVehicle(), comfortClass,
2. Truck displayVehicleInfo(), newVehicle(), height, maxCarryWeight, truckBedDimensions,
3. Motorcycle displayVehicleInfo(), newVehicle(), topSpeed, sideCar—

Members - customer information

## Interface

- Namn: VehicleRenting
- Metod(er): bookVehicle(), collectVehicle(), returnVehicle()
- Implementeras av (minst två subklasser): PassengerCar, Truck, Motorcycle

## Meny

Book ride -> select/find ride -> select member -> duration -> finalize reservation
Collect ride -> select member-> asset delivered
Return ride -> select vehicle -> asset returned
Admin/ManageInventory -> newVehicle(), removeVehicle()

implemented by most if not all vehicleSubclasses (PassengerCar, Truck, Motorcycle)

will have to iterate on menu flow. has to be smooth experience with CRS!

## Felscenarion

UserInput from scanner. handle if numbers when text expected and handle if text when numbers expected.
Handle user date data input during booking
handle if user tries to book unavailable asset
handle empty inventory scenario
handle bad user input when creating new vehicle asset

## Motivering (fylls i senare i veckan)
Created new ManageInventory.java class, unsure if this is a neat solution. CRSMenu.java just got really long. 
interface implementation somewhat shallow.
När ni kommit igång och gjort några ändringar: skriv kort varför strukturen ser ut som den gör, och om ni övervägde ett annat sätt att lösa det på. Detta behöver inte fyllas i redan i första commiten.
To be added at future point
---
