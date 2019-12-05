#include <SoftwareSerial.h> 

SoftwareSerial BT(10,11); //10 RX, 11 TX

const byte potencioMetro = 3;
const byte magnetico = 1;
const byte temperatura = 2;
const byte rmps = 4;

int digPin = 2;
int sens = 90;
int stat = HIGH;
int stat2;


short half_revolutions = 0;
short rpm = 0;
unsigned long lastmillis = 0;


void setup()
{
  BT.begin(9600);
  Serial.begin(9600);
  delay(250);
  pinMode(digPin, OUTPUT);     // pin en modo salida
}


void loop()
{
   digitalWrite(digPin, HIGH);    

  int val = analogRead(rmps);
  if(val < sens)
      stat = HIGH;
    else
      stat = LOW;
    
  if(stat2 != stat) { 
    half_revolutions++;
    stat2 = stat;
  }
 


  if (millis() - lastmillis >=  1000){
      rpm = (half_revolutions / 2) * 60;

       analogReference (INTERNAL2V56);
       int value = analogRead(temperatura);
       float celsius = (value / 1023.0) * 256;
       analogReference(DEFAULT);
      if(BT.available())
      {
          String potencioMetroStr = String(analogRead(potencioMetro) * 5.0 /1023);
          String magneticoStr = String(analogRead(magnetico) * 5.0 / 1023); 
          String msj = potencioMetroStr + " v ," + magneticoStr + " v,"+ celsius + " C ,"+ rpm + " RPM \n";
          BT.print(msj);
          BT.flush();
      }
      
      half_revolutions = 0;
      lastmillis = millis(); 
   }
}

void rpm_fan(){
  half_revolutions++;
}




