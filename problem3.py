#!/usr/bin/env python3
if __name__ == "__main__":
    f = open("article.txt","r")
    lines = f.readlines()
    f.close()
    f = open("article.txt","w")
    for line in lines:
        words_in_line = len(line.split())
        f.write(line[:-1] + str(words_in_line) + "\n")