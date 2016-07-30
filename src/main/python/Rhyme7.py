n = raw_input("")
q = long(raw_input(""))
a = []
for x in range(0,q):
    v = raw_input("").split(' ')
    l = long(v[0]) - 1
    r = long(v[1])
    v = long(n[l:r])
    if v % 7 == 0:
        a.append("YES")
    else:
        a.append("NO")


for x in range(0,q):
    print a[x]