Logic behind the algo:
If we count the frequencies of each character, we want each frequency to be unique.
Therefore, if we list all the frequencies in a line we want each frequencey appearing only once in the line.
Since the question allows only deleting a character so these frequencies could only be made unique by reduced them.

So the algo does just that.
1. Count the frequency of each character in the string. Since the question limits characters to be only small case letters we can keep the count in a 26 size array.
2. Looping over the array from 1. we see what is the frequency of this character. we keep the record of number of times a letter has appeared in a map of frequencies. Where key is the frequency and value is the number of times its appeared (it will be 1 if only a single character has that frequency else it will have value greater than one)
4. If the frequency value is greater than one then it means we need to delete/reduce this letter by one and increasing the minCharsToDelete by one. By reducing the freq count by one it may so happen that another freq (which means another letter) might have that count. So it means we will need to reduce the freq by one again and repeating it until either the freq has unique count or the count becomes zero.
5. Finally returning the minCharsToDelete (minChars in the algo)
