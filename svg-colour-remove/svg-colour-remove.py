from bs4 import BeautifulSoup

# load the SVG file
with open("Group.svg", "r") as file:
    soup = BeautifulSoup(file, "lxml-xml")  # 'lxml-xml' for parsing XML

# find and remove all elements with a specific fill
elements_removed = 0
for element in soup.find_all(attrs={"fill": "#F5645D"}):
    element.decompose()
    elements_removed += 1

# save the "clean" SVG
with open("output.svg", "w") as file:
    file.write(str(soup))

print(f"Process completed. Removed {elements_removed} elements.")
