const int buttonPin = 2;
int count = 0;
int debounceDelay = 200;
long lastDebounceTime = 0;
int buttonState = 1;

void buttonPressed() {
  int reading = digitalRead(buttonPin);

  if ((millis() - lastDebounceTime) > debounceDelay) {
    if (reading != buttonState) {
      buttonState = reading;

      lastDebounceTime = millis();
      Serial.println("Interrupt");
      count += 1;
    }
  }

}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.
  // Three edge types are supported: CHANGE, RISING, and FALLING
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, RISING);
  Serial.begin(9600);
}

void loop() {

  //Serial.println(count);
}
