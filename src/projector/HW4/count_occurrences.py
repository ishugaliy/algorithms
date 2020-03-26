# C. Write a recursive function that counts the number of occurrences of an item in nested lists. For example:
# >>> count_occurrences(2, [1, [4, [5, 2], 2], [8, [2, 9]]])
# 3


def count_occurrences(value, arr):
    counter = 0
    for el in arr:
        if isinstance(el, list):
            counter += count_occurrences(value, el)
        else:
            counter += 1 if el == value else 0
    return counter


print(count_occurrences(2, [1, [4, [5, 2], 2], [8, [2, 9]]]))
