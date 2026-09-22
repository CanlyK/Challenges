// Create collection with reference to newly created DB
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.createCollection('products');

// JSON schema validator
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.createCollection('gadgets', {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["name", "price", "inStock"],
         properties: {
            name: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            price: {
               bsonType: ["int", "double"],
               description: "must be an int or double and is required"
            },
            inStock: {
               bsonType: "bool",
               description: "must be an boolean and is required"
            },
            specs: {
               bsonType: "object",
               description: "must be an object",
               properties: {
                  brand: {
                     bsonType: "string",
                     description: "must be a string"
                  }
               }
            }
         }
      }
   },
   validationAction: "error"
});

// Insert 3 gadgets
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.insertMany([
	{ name: 'Wireless Mouse', price: 20, inStock: true, specs: { brand: 'Logitech' }},
	{ name: 'Mechanical Keyboard', price: 59.99, inStock: true },
   { name: 'Gaming Monitor', price: 600.59, inStock: true }
]);

// Insert 1 wrong input for validation
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.insertOne({
   name: 'Wireless Mouse',
   price: 'wrong',
   inStock: true
});

// Use updateOne() with $set to add new field
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.updateOne(
   { name: 'Wireless Mouse' },
   { $set: { category: 'Accessories' }}
);

// Use $inc to increase price by $15
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.updateOne(
   { name: 'Wireless Mouse' },
   { $inc: { price: 15 }}
);

// Add array field tags and push 'wireless'
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.updateOne(
   { name: 'Wireless Mouse' },
   { $push: { tags: 'wireless' }}
);

// Push 'bestseller'
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.updateOne(
   { name: 'Wireless Mouse' },
   { $push: { tags: 'bestseller' }}
);

// Use $pull to remove 'wireless' from tags array
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.updateOne(
   { name: 'Wireless Mouse' },
   { $pull: { tags: 'wireless' }}
);

// Use $gte to find all products greater than $50
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.find({ price: { $gte: 50 } });

// Find all products based on brand
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.find({ "specs.brand": 'Logitech'});

// Use $in to find products which category in list
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.gadgets.find({ category: {$in: ['Accessories']}});

// Create second collection orders
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.createCollection('orders');

// Insert document that links products _id to an order
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
const product = gadgetGalaxyDB.gadgets.findOne({ name: 'Wireless Mouse'});
gadgetGalaxyDB.orders.insertOne({ productId: product._id, quantity: 2});

// Use $lookup and $unwind to join orders with products
// Use $project to show $product.name, quantity, hide _id field
const gadgetGalaxyDB = db.getSiblingDB('gadgetGalaxyDB');
gadgetGalaxyDB.orders.aggregate([
	{ $lookup: { from: 'gadgets', localField: 'productId', foreignField: '_id', as: 'product' } },
	{ $unwind: '$product' },
   { $project: { _id: 0, name: '$product.name', quantity: 1 } }
]);