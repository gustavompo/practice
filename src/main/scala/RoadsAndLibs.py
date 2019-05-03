cities = 3
adj = []
for x in range(0, cities):
    for y in range(0, cities):
        if len(adj) <= y:
            adj.append([False])
        else:
            adj[y].append(False)

conns = [[1, 2], [3, 1], [2, 3]]

for con in conns:
    adj[con[0]-1][con[1]-1] = True

visited = []
current_cluster = []
cumulative_cost = 0
for i in range(0, cities):


print('\n'.join([', '.join([str(j) for j in l]) for l in adj]))
