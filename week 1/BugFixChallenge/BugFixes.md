
# Bug Fix Documentation

## Bug 1: Blocking the EDT
- Symptom: The application freezes.
- Cause: A long operation runs on the EDT.
- Fix: Used a background thread.
- Code Change: Used new Thread() and SwingUtilities.invokeLater().

## Bug 2: Missing Listener
- Symptom: The button does nothing.
- Cause: No ActionListener was registered.
- Fix: Added an ActionListener.
- Code Change: Added count++ to increase the counter.

## Bug 3: Wrong Thread
- Symptom: GUI may behave unpredictably.
- Cause: GUI updated from a background thread.
- Fix: Used SwingUtilities.invokeLater().
- Code Change: Updated the time label on the EDT.

## Bug 4: Memory Leak
- Symptom: Memory references remain after removing buttons.
- Cause: The ArrayList still holds references.
- Fix: Cleared the ArrayList.
- Code Change: Added createdButtons.clear().
