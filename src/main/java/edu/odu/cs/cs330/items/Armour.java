package edu.odu.cs.cs330.items;

import java.util.Scanner;

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
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(src.name);

        this.defense = src.defense;
        this.durability = src.durability;
        this.material = src.material;
        this.modifier = src.modifier;
        this.modifierLevel = src.modifierLevel;
        this.element = src.element;
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
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name    = snr.next();
        this.material = snr.next();
        this.durability = Integer.valueOf(snr.next());
        this.defense = Integer.valueOf(snr.next());
        this.modifier = snr.next();
        this.modifierLevel = Integer.valueOf(snr.next());
        this.element = snr.next();
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();

        cpy.name = this.name;
        cpy.material = this.material;
        cpy.durability = this.durability;
        cpy.defense = this.defense;
        cpy.modifier = this.modifier;
        cpy.modifierLevel = this.modifierLevel;
        cpy.element = this.element;

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
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

        return (this.name == null ? rhsItem.name == null : this.name.equals(rhsItem.name)) 
        && (this.material == null ? rhsItem.material == null : this.material.equals(rhsItem.material))
        && (this.modifier == null ? rhsItem.modifier == null : this.modifier.equals(rhsItem.modifier))
        && (this.element == null ? rhsItem.element == null : this.element.equals(rhsItem.element));
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        // Complete this function.
        // Remove the placeholder return
        return this.name.hashCode() + this.material.hashCode() + this.modifier.hashCode() + this.element.hashCode();
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {

        // Complete this function... treat the return as a hint.
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %s", this.getDurability()),
            String.format("  Def: %s", this.getDefense()),
            String.format("  Mtl: %s", this.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", this.getModifier(), this.getModifier()),
            String.format("  Emt: %s", this.getElement()),
            ""
        );
    }
}




