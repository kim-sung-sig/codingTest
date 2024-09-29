def d(n):
    k = str(n)
    result = 0
    for i in range( len(k) ):
        result += int(k[i])
        
    return n+result


cheak = [ i for i in range(1,10001)]
count = []
for i in range(1,10001):
    if d(i)<10001:
        count.append(d(i))

count_1 = set(count)
for i in count_1:
    cheak.remove(i)
    
cheak.sort()

for i in cheak:
    print(i)