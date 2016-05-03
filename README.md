## Java Decryptor Approximator
To run you can use the jar file:

```sh
$ java -jar decoder-all-1.0-SNAPSHOT.jar <file to read from> <file to write to> <threshold>
```
### How does it work:
It first locates the 'most valid string' that is the string that has more english alphabet characters and numbers, with no other symbols. After that it compares that string using the [Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance). Using the threshold (0.0 - 1.0) provided it will return the closest strings to the valid string. That is a value of 0.2 will return less but more encrypted string, where a threshold of 0.9 has a high change of containing readable strings.

