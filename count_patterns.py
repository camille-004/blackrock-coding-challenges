import sys


def count_overlapping_substr(string, substring):
    count = start = 0

    # Search through the string
    while True:
        # Find a substring from the start to the end
        start = string.find(substring, start) + 1
        if start > 0:
            count += 1
        else:
            return count


def doSomething(blob, pattern):
    # Initialize count array for pattern counts
    count = []

    if pattern == '':
        # Account for 'no pattern' case, store 0 for each blob
        count = [0] * len(blob)
    else:
        for blob in blobs:
            # Utilize count() method to count substrings in a string
            count.append(count_overlapping_substr(blob, pattern))

    # Add the sum of the counts to the end
    count.append(sum(count))

    # Turned this array into a string whose elements are separated by '|'
    string = '|'.join([str(c) for c in count])
    return string


for line in sys.stdin:
    splitted_input = line.split(';')
    pattern = splitted_input[0]
    blobs = splitted_input[1].split('|')

    result = doSomething(blobs, pattern)
    print(result)
