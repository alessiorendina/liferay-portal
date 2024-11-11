<#assign initialCapacity = entityColumns?size + 2 />

<#if entity.hasLazyReference() && entity.isStrictLazyReference() && !entityFinder.name?contains("_BIS")>
	<#assign initialCapacity += 1 />
</#if>

StringBundler sb = null;

if (orderByComparator != null) {
	sb = new StringBundler(${initialCapacity} + (orderByComparator.getOrderByFields().length * 2));
}
else {
	sb = new StringBundler(${initialCapacity});
}

sb.append(_SQL_SELECT_${entity.alias?upper_case}_WHERE);

<#if entity.hasLazyReference() && entity.isStrictLazyReference() && !entityFinder.name?contains("_BIS")>
	sb.append(_SQL_BATCH_IMPORT_STATUS_WHERE_CLAUSE_AND);
</#if>

<#include "persistence_impl_finder_cols.ftl">

if (orderByComparator != null) {
	appendOrderByComparator(sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
}
else {
	sb.append(${entity.name}ModelImpl.ORDER_BY_JPQL);
}