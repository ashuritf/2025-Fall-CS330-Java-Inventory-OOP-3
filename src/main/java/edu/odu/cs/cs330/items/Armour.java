package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return -1;
    }

    @Override
    public void fromTokens(String[] tokens)
    {
        this.setName(tokens[0]);

        // Add the missing lines

    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();

        cpy.setName(this.name);

        cpy.setDurability(this.getDurability());
        cpy.setDefense(this.defense);
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return this.name.equals(rhsItem.name)
            && this.getMaterial().equals(rhsItem.getMaterial()) 
            && this.getModifier().equals(rhsItem.getModifier())
            && this.getModifierLevel() == rhsItem.getModifierLevel()
            && this.getElement().equals(rhsItem.getElement())
            && this.defense == rhsItem.defense;

    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return this.name.hashCode() 
            + this.getMaterial().hashCode() 
            + this.getModifier().hashCode()
            + this.getModifierLevel()
            + this.getElement().hashCode()
            + this.defense;
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        // Use String.format and the provided FMT_STR
        return String.format(
            FMT_STR, 
            super.name,
            this.getDurability(), 
            this.defense,
            this.getMaterial(),
            this.getModifier(), this.getModifierLevel(),
            this.getElement()
        );
    }
}




