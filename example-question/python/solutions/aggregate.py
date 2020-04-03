#!/bin/python

import math
import os
import random
import re
import sys

def AggregateNames(nameList):
    aggregated = {}
    
    for name in nameList :
        if name in aggregated.keys():
            aggregated[name] += 1
        else:
            aggregated[name] = 1
    return aggregated


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nameList_count = int(raw_input().strip())

    nameList = []

    for _ in xrange(nameList_count):
        nameList_item = raw_input()
        nameList.append(nameList_item)

    result = AggregateNames(nameList)
    for key in sorted(result.keys()):
        fptr.write(str(key) + ' ' + str(result[key]) + '\n')

    fptr.close()
