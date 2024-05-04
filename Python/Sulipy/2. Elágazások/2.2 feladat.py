'''
Készíts egy programot, amely a felhasználótól két külön kérdésben megkérdezi,
hogy az ikrek (Henrik és Hanna) jönnek-e ma kosrazni!
Például így: Jön Henrik ma kosarazni? (igen/nem).
A program írja ki, hogy melyik állítás igaz az alábbiak közül:
    egyikük sem jön kosarazni,
    mind a ketten jönnek kosarazni,
    csak az egyikük jön kosarazni.
'''
kerdes1 = input('Jön Henrik ma kosarazni? (igen/nem)\n\tVálasz: ')
kerdes2 = input('Jön Hanna ma kosarazni? (igen/nem)\n\tVálasz: ')

if kerdes1 == 'nem' and kerdes2 == 'nem':
    print('Egyikük sem jön kosarazni.')
elif kerdes1 == 'igen' and kerdes2 == 'igen':
    print('Mind a ketten jönnek kosarazni.')
else:
    print('Csak az egyikük jön kosarazni.')